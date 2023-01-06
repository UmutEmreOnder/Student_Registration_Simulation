import logging

class CustomFormatter(logging.Formatter):
    def format(self, record):
        # Customize the log message format
        return record.getMessage()
