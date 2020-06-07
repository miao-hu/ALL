from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(3)

# driver.find_element_by_xpath("//*[@id='kw']").send_keys("腾讯2020春招")
# driver.find_element_by_xpath("//*[@id='su']").click()

driver.find_element_by_css_selector(".s_ipt").send_keys("终南山")
driver.find_element_by_css_selector("#su").click()
# 如果采用css的方式：选 id 那么要加上 #   ; 选 name 要加上 .

# driver.find_element_by_css_selector("#kw").send_keys("终南山")
# driver.find_element_by_css_selector("#su").click()

time.sleep(3)
driver.quit()
