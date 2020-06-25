# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest
import time
from selenium.common.exceptions import NoAlertPresentException
from selenium.common.exceptions import NoSuchElementException
from ddt import ddt, unpack, data, file_data
import sys, csv
import os

@ddt    # 给该类引入数据驱动
class Baidu1(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com//"
        self.verificationErrors=[]
        self.accept_next_alert = True

    def tearDown(self):
        self.driver.quit()
        self.assertEqual([],self.verificationErrors)

    @file_data('test_baidu_data.json')
    def test_hao(self, value):            # value就是从该文件中取出的数据
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)     # value就是从该文件中取出的数据
        driver.find_element_by_id("su").click()
        time.sleep(3)
        print(driver.title)
if __name__ == "__main__":
    unittest.main()
    
    
