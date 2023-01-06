

class Config:
    def __init__(self, pass_probability=None, grade_luck=None, grade_variance=None, minimum_credit_req=None):
        self.pass_probability = pass_probability
        self.grade_luck = grade_luck
        self.grade_variance = grade_variance
        self.minimum_credit_req = minimum_credit_req

    @property
    def pass_probability(self):
        return self.pass_probability

    @pass_probability.setter
    def pass_probability(self, pass_probability):
        self.pass_probability = pass_probability

    @property
    def grade_luck(self):
        return self.grade_luck

    @grade_luck.setter
    def grade_luck(self, grade_luck):
        self.grade_luck = grade_luck

    @property
    def grade_variance(self):
        return self.grade_variance

    @grade_variance.setter
    def grade_variance(self, grade_variance):
        self.grade_variance = grade_variance

    @property
    def minimum_credit_req(self):
        return self.minimum_credit_req

    @minimum_credit_req.setter
    def minimum_credit_req(self, minimum_credit_req):
        self.minimum_credit_req = minimum_credit_req
