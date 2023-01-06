from src.main.marmara.service.impl import JsonServiceImpl
from src.main.marmara.view import View

json_service = JsonServiceImpl()

def main(args):
    try:
        View.start()
        json_service.end()
    except Exception as e:
        View.logger.warning(e.message)
