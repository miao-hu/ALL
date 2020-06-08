from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(2)
driver.maximize_window()   # 浏览器的最大化

driver.find_element_by_link_text("hao123").click()
driver.implicitly_wait(10)

title = driver.title
print(title)

url = driver.current_url
print(url)

time.sleep(2)
driver.quit()
