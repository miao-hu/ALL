# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest
import time
from selenium.common.exceptions import NoAlertPresentException
from selenium.common.exceptions import NoSuchElementException

class Baidu1(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.driver.maximize_window()             # 最大化窗口
        self.verificationErrors=[]                # 存放输出的错误信息
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

    # @unittest.skip("skipping")
    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url)                 # 打开百度
        driver.find_element_by_link_text("hao123").click()
        time.sleep(3)
        #self.assertEqual(u"hao_上网从这里开始", driver.title, msg="not  equal!!!")
        self.assertTrue("admin"=="admin1", msg="True")
        time.sleep(2)

    # @unittest.skip("skipping")
    def test_baidusearch(self):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"大虞海棠")
        driver.find_element_by_id("su").click()
        time.sleep(3)

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
    #             alert.accept()
    #         else:
    #             alert.dismiss()
    #         return alert_text
    #     finally: self.accept_next_alert = True
    if __name__=="__main__":
        unittest.main(verbosity=2)
        
        
