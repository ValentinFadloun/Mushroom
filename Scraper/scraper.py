# -*- coding: utf-8 -*-
from bs4 import BeautifulSoup
from splinter import browser
from pymongo import MongoClient
from pprint import pprint

import urllib
import requests
import json
import lxml.html


client = MongoClient('192.168.99.100:27017')
db=client.scrapervince
#initialise le mot de à rechercher
resultsGlob=[]


#On recherche les URL du résultat de la recherche vec beautifulSoup
"""Fonctions qui récupère les URL des résultats de la recherche
    query = str mot  recherché
    nbpages = int nbre de pages à scraper
    """
def getSites(query, nbpages):
    USER_AGENT =  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36"
    pagenum = 0
    
    while pagenum <= nbpages:
        query = query +"&start="+str(pagenum)
        query.replace(" ","+")
        URL = f"https://google.com/search?q={query}"

        resultsGlob = []
        results = []
        search=[]

        headers = {"user-agent": USER_AGENT}
        resp = requests.get(URL, headers=headers)
        with open("fileTestListSites.json", "w") as mj:
            if resp.status_code == 200:
                soup = BeautifulSoup(resp.content, "html.parser")
                for g in soup.find_all('div', class_='r'):
                    anchors = g.find_all('a')
                    if anchors:
                        link = anchors[0]['href']
                        title = g.find('h3').text
                        shortdescription = g.find('a').text
                        item = {
                            "title": title,
                            "link": link,
                            "shortdescription": shortdescription
                        }
                        search.append(link)
                        resultsGlob.append(item)#Résultat à intégrer dans la BDD pour éventuel recherche/mot clé et présentaion en nuage
                        résultat = db.reviews.insert_one (item)      
        pagenum=pagenum+1
    return(search)

search = getSites("covid 19",5)