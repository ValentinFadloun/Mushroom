# -*- coding: utf-8 -*-
"""
Auteur : Vince
Date : 13/04/2020
Permet le plug sur API covid19api.com et récupère les data tout les jours en les actualisants
MAJ 30/04/2020 : Optimisation de la fonction d'update et simplification du code
"""
from flask import Flask, render_template, jsonify
from pymongo import MongoClient
import json
import requests
import time
from datetime import datetime

# Connection à la BDD /!\ /!\ /!\ En local à changer
client = MongoClient('localhost:27017')

"""récupère les datas tout les jours 
    source_URL = url
    dbname = Nom_de_la_bdd"""


def getGlobal(source_URL, dbname, name):
    response = requests.get(source_URL)
    db = dbname
    content = json.loads(response.content)
    dbnames = client.list_database_names()
    dbnames = client.list_database_names()

    if name in dbnames:
    # Parcours les données de l'API
        for prev in content:
            prev = {k.lower() : v for k, v in prev.items()}
            db.reviews.insert_one(prev)


t = True
while(t):
    getGlobal("https://api.covid19api.com/all", client.resultcovid19api_all, "resultcovid19api_all")
    print("C'est tout pour aujourd'hui, à demain !")
    time.sleep(86400)
