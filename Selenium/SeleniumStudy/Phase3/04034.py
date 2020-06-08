from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(3)

driver.find_element_by_id("kw").send_keys("比特科技")
time.sleep(3)
driver.find_element_by_id("kw").clear()    # 清除输入框的内容

driver.find_element_by_id("kw").send_keys("清明节")
driver.find_element_by_id("su").submit()           # submit() 和 click() 完全一样
# driver.find_element_by_id("su").click()

time.sleep(3)
driver.quit()
