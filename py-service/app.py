from flask import Flask
import py_eureka_client.eureka_client as eureka_client
from spring_config import ClientConfigurationBuilder
from spring_config.client import SpringConfigClient

service_name = 'py-service'

config = ClientConfigurationBuilder().app_name(service_name).address('http://config:8888').build()
c = SpringConfigClient(config)
service_config = c.get_config()

eureka_server = service_config['eureka']['client']['serviceURL']['defaultZone']
rest_port = service_config['server']['port']

eureka_client.init(eureka_server=eureka_server,
                   app_name=service_name,
                   instance_port=rest_port)

app = Flask(__name__)

@app.route("/py-hello/process-hello/<string:greeting>", methods=['GET'])
def hello(greeting: str):
    greeting += "\nAnd hello from Python"
    app.logger.info('PYTHON_LOG:', 'Python did its job')
    return greeting

if __name__ == "__main__":
    app.run(host='0.0.0.0', port = rest_port)