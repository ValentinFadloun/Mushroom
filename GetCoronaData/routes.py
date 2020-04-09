from app import app
from flask import Flask, render_template, jsonify
import json
import requests
import random
import datetime
import time

source_URL="https://api.covid19api.com/all"

@app.route('')
# c'est ici qu'on défini notre "DataLake" ?

def datetri(M):
    return M[1]

@app.route('/infoglobal/')
def getinfoglobal():
    response = requests.get(source_URL)
    content = json.loads(response.content.decode('utf-8'))

    if response.status_code != 200:
        return jsonify({
            'status': 'error',
            'message': 'La requête à l\'API corona n\'a pas fonctionné. Voici le message renvoyé par l\'API : {}'.format(content['message'])
        }), 500
    t=True

    while(t) :
        
        data = [] # On initialise une liste vide
    
        #Avec foreach 
        for prev in content["list"]:
            pays=prev['Country']
            nbcas=prev['Cases']
            status=prev['Status']
            date=prev['Date']
            data.append([pays, nbcas,status, date])
        sorted(data,key=datetri)
 
        return jsonify({
        'status': 'ok', 
        'data': data
        })
        
        time.sleep(86400)

if __name__ == "__main__":
    app.run()

