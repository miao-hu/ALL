# coding = utf-8
from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
driver.find_element_by_link_text("新闻").click()       # 找到页面有文本为新闻的
time.sleep(2)
driver.quit()
