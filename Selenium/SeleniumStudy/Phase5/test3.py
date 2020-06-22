# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest
import time
import os
import re
from selenium.common.exceptions import NoAlertPresentException
from selenium.common.exceptions import NoSuchElementException


class Baidu1(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.verificationErrors=[]
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()
        self.assertEqual([],self.verificationErrors)

    @unittest.skip("skipping")      # 忽略此测试用例
    def test_baidusearch(self):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"大虞海棠")
        driver.find_element_by_id("su").click()
        time.sleep(3)


    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_link_text("hao123").click()    # 点击hao123
        driver.maximize_window()                              # 最大化窗口
        try:
            self.assertEqual(u"上网从这里开始", driver.title)  # 断言
        except:
            self.saveScreenShot(driver, "hao.png")   # 出现异常就调用截图函数进行页面截图
        time.sleep(3)

    # 截图函数
    def saveScreenShot(self, driver, file_name):   # 参数：驱动，截图文件名称
        if not os.path.exists("./image"):
            os.makedirs("./image")                 # 创建目录
        now = time.strftime("%Y%m%d%H%M%S", time.localtime(time.time()))
        print(now)
        driver.get_screenshot_as_file("./image/"+now+"-"+file_name)
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
    if __name__ == "__main__":
        unittest.main(verbosity=2)
