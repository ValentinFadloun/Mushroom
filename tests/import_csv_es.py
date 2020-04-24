# Import d'elasticsearch
from elasticsearch import Elasticsearch, helpers

es = Elasticsearch([{'host': '192.168.99.100', 'port': '9200'}], http_auth=('elastic', 'changeme'))

import json

def generate_data():
    # Ouverture du fichier csv
    with open('C:\\Users\\vfadl\\Documents\\Formation_CAPGEMINI\\projet\\Mushroom\\DATA\\shortversion.json','r') as jsonfile:
        data = json.load(jsonfile)
        for json_object in data["Countries"]:
            yield {
                "_index": "covid_19",
                "_type":"doc",
                "_source": json_object
            }


helpers.bulk(es, generate_data())