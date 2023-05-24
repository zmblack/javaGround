import requests
import json
print("asddddd11dd")

path="https://dict.youdao.com/suggest?num=5&ver=3.0&doctype=json&cache=false&le=en&q=egg"
response = requests.request("GET", path)
print(response.text)
res_code = json.loads(response.text)["result"]["code"]
if res_code != 200:
    print("get_token() error: ")
else:
     a=json.loads(response.text)["data"]
     print(a["entries"][0]["explain"])
     print(a["entries"][0]["entry"])
