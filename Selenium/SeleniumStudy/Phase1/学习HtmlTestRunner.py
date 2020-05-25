# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包
import unittest                   # 导入 python 测试框架
import HTMLTestRunner             # 导入测试报告输出的一个功能组件
# 声明一个类
class WebToursTest(unittest.TestCase):
    # 初始化测试环境
    def setUp(self):
        self.driver = webdriver.Chrome()              # 创建 chrome 对象
        self.driver.get("http://127.0.0.1:1080/WebTours/")
        time.sleep(3)                            # 网页打开后等待停止3秒

    # 测试主体部分
    def testLogin(self):
        self.driver.switch_to.frame("body")  # 根据name的值来进入一个框架
        self.driver.switch_to.frame("navbar")  # 根据name的值来进入一个框架

        username = self.driver.find_element_by_xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")
        password = self.driver.find_element_by_xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")
        login = self.driver.find_element_by_xpath("/html/body/form/table/tbody/tr[8]/td[2]/input")
        username.send_keys("test")
        password.send_keys("bean")
        login.click()

        time.sleep(3)  # 目的是为了查看效果

    # 收尾部分
    def tearDown(self):
        self.driver.quit()               # 关闭 chrome 对象

# 测试报告的生成过程
if __name__ == "__main__":
    test = unittest.TestSuite()                 # 创建一个测试套件（测试集）
    test.addTest(WebToursTest('testLogin'))     # 把测试用例加载进来   类名（“方法名”）
    file_result = open('./WebToures.html','wb')
    runner = HTMLTestRunner.HTMLTestRunner(stream=file_result,title=u"WebTours测试报告",description=u"测试用例执行情况")
    runner.run(test)
    file_result.close()













