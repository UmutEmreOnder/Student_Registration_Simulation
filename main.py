from src.main.marmara.service.impl.JsonServiceImpl import JsonServiceImpl
from src.main.marmara.view.View import View

json_service = JsonServiceImpl()

def main(args):
    try:
        View.start()
        json_service.end()
    except Exception as e:
        View.logger.warning(e.message)
