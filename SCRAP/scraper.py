# -*- coding: utf-8 -*-
"""
Auteur : Vince
Doc :
Scraper permettant de récupérer les infos sur les pages d'une recherche Google.
Afin de ne garder que les résultats pertinents, on limite le nombre de page retournées (en l'occurrence 5).
Extrait : Le titre
          URL
          ShortDescription
Utilise BeautifulSoup.
MAJ 30/04/2020 : Update les données + ajouts du champ date + boucle infini
"""
from bs4 import BeautifulSoup
from splinter import browser
from pymongo import MongoClient
from pprint import pprint
from datetime import datetime
import urllib
import requests
import json
import time

# Connection à la BDD /!\ /!\ /!\ En local à changer
client = MongoClient('192.168.99.100:27017')


"""Fonctions qui récupère les URL des résultats de la recherche
    query = str mot  recherché
    nbpages = int nbre de pages à scraper
    """
def getSites(query, nbpages):
    keyword = query
    db = client.google_scraper
    resultsGlob = []

    USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36"
    pagenum = 0

    while pagenum <= nbpages:
        query = query + "&start="+str(pagenum)
        query.replace(" ", "+")
        URL = f"https://google.com/search?q={query}"

        resultsGlob = []
        results = []
        search = []

        headers = {"user-agent": USER_AGENT}
        resp = requests.get(URL, headers=headers)
        if resp.status_code == 200:
            soup = BeautifulSoup(resp.content, "html.parser")
            for g in soup.find_all('div', class_='r'):
                anchors = g.find_all('a')
                if anchors:
                    link = anchors[0]['href']
                    title = g.find('h3').text
                    shortdescription = g.find('a').text
                    item = {
                        "Date": str(datetime.now()),
                        "title": title,
                        "link": link,
                        "shortdescription": shortdescription,
                        "ref": keyword
                    }
                    if not db.reviews.find_one(item):
                        db.reviews.insert_one(item)
        pagenum = pagenum + 1

# Liste de mots recherché
search = ["covid 19", "corona virus", "covid actu", "confinement"]

t = True
while(t):
    for word in search:
        getSites(word, 5)
    print("C'est tout pour aujourd'hui, nouvelles entrées, à demain !")
    time.sleep(86400)
