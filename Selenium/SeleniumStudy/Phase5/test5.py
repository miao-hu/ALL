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


    @data(["Lsia",u"Lsia_百度搜索"],[u"双笙",u"双笙_百度搜索"],["999",u"999_百度搜索"])
    @unpack    # 含义：自动匹配好对应的所有值
    def test_hao(self, value,expected_value):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)    # 该值就是上述的值
        driver.find_element_by_id("su").click()
        time.sleep(2)
        self.assertEqual(expected_value, driver.title)      # 断言
        print(expected_value)     # 期待的值
        print(driver.title)       # 实际的值

if __name__ == "__main__":
    unittest.main()
    
    
