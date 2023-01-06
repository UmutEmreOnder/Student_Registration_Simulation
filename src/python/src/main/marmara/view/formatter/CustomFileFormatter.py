import logging

class CustomFileFormatter(logging.Formatter):
    def format(self, record: logging.LogRecord) -> str:
        # Customize the log message format
        return f"{record.levelname} {record.msg}"
