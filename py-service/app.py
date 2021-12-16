from flask import Flask
import py_eureka_client.eureka_client as eureka_client

rest_port = 8082
eureka_client.init(eureka_server="http://registry:8761/eureka",
                   app_name="py-service",
                   instance_port=rest_port)

app = Flask(__name__)

@app.route("/py-hello/process-hello/<string:greeting>", methods=['GET'])
def hello(greeting: str):
    greeting += "\nAnd hello from Python"
    return greeting

if __name__ == "__main__":
    app.run(host='0.0.0.0', port = rest_port)