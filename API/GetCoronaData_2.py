# -*- coding: utf-8 -*-
"""
Auteur : Vince
Date : 13/04/2020
Permet le plug sur API covid19api.com et récupère les data tout les jours en les actualisants
MAJ 30/04/2020 : Optimisation de al fonction d'update et simplification du code
"""
from flask import Flask, render_template, jsonify
from pymongo import MongoClient
import json
import requests
import time
from datetime import datetime

# Connection à la BDD /!\ /!\ /!\ En local à changer
client = MongoClient('192.168.99.100:27017')

"""récupère les datas tout les jours 
    source_URL = url
    dbname = Nom_de_la_bdd"""


def getGlobal(source_URL, dbname):
    response = requests.get(source_URL)
    db = dbname
    content = json.loads(response.content)
    dbnames = client.list_database_names()
    # Parcours les données de l'API
    for prev in content:
        # Si les données en BDD n'existent pas on les insère
        if not db.reviews.find_one(prev):
            db.reviews.insert_one(prev)


t = True
while(t):
    getGlobal("https://api.covid19api.com/all", client.resultcovid19api_all)
    print("C'est tout pour aujourd'hui, nouvelles entrées, à demain !")
    time.sleep(86400)
