class WeeklyDate:
    def __init__(self, day_name, hours):
        self.day_name = day_name
        self.hours = hours

    def __str__(self):
        return f"WeeklyDate{{ day_name={self.day_name}, hours={self.hours} }}"

    def get_day_name(self):
        return self.day_name

    def set_day_name(self, day_name):
        self.day_name = day_name

    def get_hours(self):
        return self.hours

    def set_hours(self, hours):
        self.hours = hours
