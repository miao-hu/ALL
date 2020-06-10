from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(3)

driver.find_element_by_id("kw").send_keys("腾讯2020春招")
driver.find_element_by_id("su").click()

time.sleep(4)
driver.quit()
