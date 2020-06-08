from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(2)

data = driver.find_element_by_id("su").text
# 先定位到一个元素，把它的文本内容返回给 data
print(data)

driver.quit()
