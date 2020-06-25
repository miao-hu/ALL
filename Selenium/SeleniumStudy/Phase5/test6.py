# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest
import time
from selenium.common.exceptions import NoAlertPresentException
from selenium.common.exceptions import NoSuchElementException
from ddt import ddt, unpack, data, file_data
import sys, csv
import os

# 在 Python 里面，方法可以定义在类的外部，因为 Python 是一门解释性语言
def getCsv(file_name):
    rows=[]
    # 此处需要注意编码格式
    with open('./data/'+file_name, 'rt',  encoding='UTF-8') as f:   # 以读的方式打开文件 f
        readers = csv.reader(f, delimiter=',', quotechar='|')
        next(readers, None)    # readers 中已经包含了文件的所有信息
        for row in readers:    # row 为每一行的内容
            temprows=[]
            for i in row:
                temprows.append(i)
            rows.append(temprows)   # 给 rows 增加一行
        return rows   # rows中的内容为：[周迅,周迅_百度搜索]，[张国荣，张国荣_百度搜索]

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

    @data(*getCsv('test_baidu_data.txt'))
    @unpack     # 含义：自动匹配好对应的所有值
    def test_hao(self,value,expected_value):
        driver = self.driver
        driver.get(self.base_url)
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()
        time.sleep(2)
        self.assertEqual(expected_value, driver.title)
        print(expected_value)
        print(driver.title)
if __name__ == "__main__":
    unittest.main()
    
    
