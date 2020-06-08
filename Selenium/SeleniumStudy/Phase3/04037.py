from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com/")

driver.find_element_by_link_text("hao123").click()
driver.implicitly_wait(10)           # 智能等待10秒

title = driver.title
print(title)

url = driver.current_url
print(url)

time.sleep(3)
driver.quit()
