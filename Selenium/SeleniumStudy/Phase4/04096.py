from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/QQ下载的/selenium2html/selenium2html/upload.html")
driver.get(file_path)         # 打开这个文件
time.sleep(3)

driver.find_element_by_name("file").send_keys("E:\\789456.jpg")
time.sleep(3)
driver.quit()


