from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/QQ下载的/selenium2html/selenium2html/modal.html")
driver.get(file_path)   # 打开这个文件
time.sleep(3)

driver.find_element_by_id("show_modal").click()     # 点击 click 按钮
time.sleep(3)

driver.find_element_by_id("click").click()          # 点击警告框的 click me 按钮
time.sleep(3)

# 此时 div 块中有两个按钮，该怎么确定某一个具体的按钮？
buttons = driver.find_elements_by_tag_name("button")
buttons[1].click()         # 选择 List 列表中的第一个

time.sleep(3)
driver.quit()


