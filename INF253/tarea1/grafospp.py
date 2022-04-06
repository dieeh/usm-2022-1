import re


numeros = '[1-9][0-9]{5,}'

telefono = r'\+' + numeros

id = '\#[A-Z]{2,}[0-9]{2,}'

names = '[A-Z][a-z\s\-]'

rut = '[1-9]{1,}[0-9]{7,}\-[0-9k]'