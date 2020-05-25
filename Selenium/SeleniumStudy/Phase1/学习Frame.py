# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("http://127.0.0.1:1080/WebTours/")
time.sleep(3)                     # 网页打开后等待停止3秒

driver.switch_to.frame("body")    # 根据name的值来进入一个框架
driver.switch_to.frame("navbar")  # 根据name的值来进入一个框架

username = driver.find_element_by_xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")
password = driver.find_element_by_xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")
login = driver.find_element_by_xpath("/html/body/form/table/tbody/tr[8]/td[2]/input")

'''
username = driver.find_element_by_name("username")
password = driver.find_element_by_name("password")
login = driver.find_element_by_name("login")
'''
username.send_keys("test")
password.send_keys("bean")
login.click()

time.sleep(3)                     # 目的是为了查看效果
driver.quit()                     # 关闭 chrome 对象
