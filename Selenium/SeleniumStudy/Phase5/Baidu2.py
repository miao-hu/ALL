# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest
import time
from selenium.common.exceptions import NoAlertPresentException
from selenium.common.exceptions import NoSuchElementException

class Baidu1(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()           # 获得浏览器的驱动
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.verificationErrors=[]                 # 存放输出的错误信息
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()                         # 关闭浏览器
        self.assertEqual([],self.verificationErrors)    # 断言

    # 搜索张国荣
    def test_baidusearch(self):
        driver = self.driver
        driver.get(self.base_url)                  # 打开百度
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"张国荣")
        driver.find_element_by_id("su").click()
        time.sleep(4)

    # 打开hao123页面
    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_link_text("hao123").click()
        self.assertEqual(u"hao123_上网从这里开始",driver.title)     # 断言（u 代表字符集编码）

    # 判断element是否存在，可删除
    # def is_element_present(self, how, what):
    #     try:
    #         self.driver.find_element(by=how, value=what)
    #     except NoSuchElementException as e:
    #         return False
    #     return True


    # 判断alert是否存在，可删除
    # def is_alert_present(self):
    #     try:
    #         self.driver.switch_to.alert
    #     except NoAlertPresentException as e:
    #         return False
    #     return True


    # 关闭alert，可删除
    # def close_alert_and_get_its_text(self):
    #     try:
    #         alert = self.driver.switch_to.alert
    #         alert_text = alert.text
    #         if self.accept_next_alert:
    #             alert.accept()             接受
    #         else:
    #             alert.dismiss()            关闭
    #         return alert_text              不论如何，都返回alert()窗口的文本内容
    #     finally: self.accept_next_alert = True
    if __name__=="__main__":
        unittest.main()
