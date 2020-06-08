from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(3)

# driver.find_element_by_link_text("抗击肺炎").click()          # 找到页面有元素的文本内容为抗击肺炎

# driver.find_element_by_partial_link_text("肺炎").click()     # 找到页面有元素的部分文本内容为肺炎

driver.find_element_by_tag_name("input").send_keys("123456")
# 报错：Message: element not interactable

time.sleep(3)
driver.quit()
