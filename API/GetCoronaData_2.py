# -*- coding: utf-8 -*-
"""
Auteur : Vince
Date : 13/04/2020
Permet le plug sur API covid19api.com et récupère les data tout les jours en les actualisants
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
    db=dbname    
    content = json.loads(response.content.decode('utf-8'))
    dbnames = client.list_database_names()
    new=0
    
    print(db.reviews.find_one(datetime.now()))
    if 'resultcovid19api_all' in dbnames:
        for prev in content:
            ishere = db.reviews.find_one(prev)
            if not ishere:
                db.reviews.insert_one(prev)
    elif not 'resultcovid19api_all' in dbnames:
        for prev in content:
            db.reviews.insert_one(prev)


t = True
while(t):
    getGlobal("https://api.covid19api.com/all", client.resultcovid19api_all)
    time.sleep(86400)
