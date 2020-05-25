# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包
import unittest                   # 导入 python 测试框架

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
    if __name__ == "__main__":
        unittest.main(verbosity=2)

