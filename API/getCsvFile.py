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
import csv
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

    t = True

    while(t):
        if name in dbnames:
            dbname.reviews.drop()

        i = 0
        entete = []

        with open('tempdata.csv', "wb") as file:
            # get request
            response = requests.get(source_URL)
            # write to file
            file.write(response.content)

        # Charger le csv
        with open('tempdata.csv') as csvFile:
            reader = csv.reader(csvFile)
            for row in reader:
                if (i == 0):
                    # Récupère l'entête
                    for column in row:
                        entete.append(column)
                    i += 1
                else:
                    for column in row:
                        item = {}
                        i = 0
                        for col in entete:
                            # Créé le dictionnaire
                            item[str(col)] = row[i]
                            i += 1

                    db.reviews.insert_one(item)

        os.remove('tempdata.csv')
        time.sleep(86400)


getGlobal('https://www.data.gouv.fr/fr/datasets/r/eceb9fb4-3ebc-4da3-828d-f5939712600a',
          client.resulthostoData, 'resulthostoData')
