# -*- coding: utf-8 -*-
"""
Auteur : Vince
Date : 24/04/2020
Permet le téléchargement des données aux formats csv des urgences hospitaliéres et les charges dans mongo
fait une copie local du csv puis le supprime.
L'entête du fichier n'a aucune importance, il est créé dynamiquement.
Mais à jour les données totu les jours
MAJ 27/04/2020 : Ne prend pas en compte les lignes de commentaires (commencant par #) et prend en compte les séparateur ';'
MAJ 30/04/2020 : MAJ du système d'update
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


def getGlobal(source_URL, dbname, name, sep):
    db = dbname
    dbnames = client.list_database_names()
    i = 0
    entete = []

    with open('tempdata.csv', "wb") as file:
        # get request
        response = requests.get(source_URL)
        # write to file
        file.write(response.content)

    # Charger le csv dans un fichier temp
    with open('tempdata.csv') as csvFile:
        reader = csv.reader(csvFile, delimiter=sep)
        for row in reader:
            if row[0].find('#'):
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
                    # Compare le dictionnaire avec la BDD si n'éxiste pas insére
                    if not db.reviews.find_one(item):
                        db.reviews.insert_one(item)
                        print("Add 1")
    # Supprime le fichier temp
    os.remove('tempdata.csv')


t = True
"""récupère les datas tout les jours
     source_URL = url
     dbname = Nom_de_la_bdd"""
while(t):
    getGlobal('https://www.data.gouv.fr/fr/datasets/r/eceb9fb4-3ebc-4da3-828d-f5939712600a',
              client.gouv_fr_resulthostoData, 'gouv_fr_resultHosto', ',')

    getGlobal('https://www.data.gouv.fr/fr/datasets/r/f4935ed4-7a88-44e4-8f8a-33910a151d42',
              client.gouv_fr_evoljourpays, 'gouv_fr_evoljourpays', ';')

    getGlobal('https://www.data.gouv.fr/fr/datasets/r/15a5a5b8-8330-48a0-a385-e01b326d2213',
              client.gouv_fr_evoljourpays, 'gouv_fr_evoljourpays', ';')

    getGlobal('https://www.data.gouv.fr/fr/datasets/r/6fadff46-9efd-4c53-942a-54aca783c30c',
              client.gouv_fr_nouveauCovid, 'gouv_fr_nouveauCovid', ';')

    getGlobal('https://www.data.gouv.fr/fr/datasets/r/08c18e08-6780-452d-9b8c-ae244ad529b3',
              client.gouv_fr_casAge, 'gouv_fr_casAge', ';')

    print("C'est tout pour aujourd'hui, nouvelles entrées, à demain !")
    time.sleep(86400)
