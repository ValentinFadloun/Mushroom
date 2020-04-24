# -*- coding: utf-8 -*-
"""
Auteur : Vince
Date : 24/04/2020
Permet le téléchargement des données aux formats csv des urgences hospitaliéres et les charges dans mongo
fait une copie local du csv puis le supprime.
L'entête du fichier n'a aucune importance, il est créé dynamiquement.
Mais à jour les données totu les jours
"""
from flask import Flask, render_template, jsonify
from pymongo import MongoClient
import json
import requests
import urllib.request
import time
import os

# Connection à la BDD /!\ /!\ /!\ En local à changer
client = MongoClient('192.168.99.100:27017')

"""récupère les datas tout les jours 
    source_URL = url
    dbname = Nom_de_la_bdd"""


def getGlobal(source_URL, dbname, name):
    db = dbname
    dbnames = client.list_database_names()

  #  t = True

   # while(t):
    if name in dbnames:
        dbname.reviews.drop()

    i = 0
    entete = []

    with open('tempdata.json', "wb") as file:
        # get request
        response = requests.get(source_URL)
        # write to file
        file.write(response.content)

        # Charger le csv
    with open('tempdata.json') as jsonFile:
        reader = json.load(jsonFile)
        mylist = [reader]
        db.reviews.insert_many(mylist)

        # db.reviews.insert_one(prev)

    os.remove('tempdata.json')
    # time.sleep(86400)


getGlobal('https://www.data.gouv.fr/fr/datasets/r/a7596877-d7c3-4da6-99c1-2f52d418e881',
          client.evolData, 'evolData')
