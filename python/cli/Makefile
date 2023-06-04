.PHONY: test activate init requirements.txt

# Indicates each line of command in target would run in one shell , 
# only make file version >=3.8.2 support 
.ONESHELL:

SOURCE_ENV = . venv/bin/activate

rm: 
	find . -name '*.pyc' -exec rm -f {} +
	find . -name '*.pyo' -exec rm -f {} +
	find . -name '*~' -exec rm -f {} +
	find . -type d -iname '*egg-info' -exec rm -rdf {} +
	rm -f .coverage
	rm -rf htmlcov
	rm -rf dist
	rm -rf build
	# rm -rf .py.egg-info
	rm -rf .pytest_cache
	rm -rf .hypothesis
	rm -rdf assets
	
test: 
	$(SOURCE_ENV)
	pytest -s -v  tests/

coverage-html:
	$(SOURCE_ENV) 
	# --cov where you want to cover
	#  tests  where your test code is 
	pytest --cov=cli/ --cov-report=html tests/
	open htmlcov/index.html

coverage:
	$(SOURCE_ENV) 
	pytest --cov=cli/ tests/


install: uninstall
	$(SOURCE_ENV) 
	pip3 install . 

uninstall:
	$(SOURCE_ENV) 
	pip3 uninstall  -y cli

main:
	$(SOURCE_ENV) 
	python3 main.py eat -c 2

run:
	$(SOURCE_ENV) 
	python3 -m cli eat -c 2

wrun:
	$(SOURCE_ENV) 
	watchexec -ce py 'python3 -m cli eat -c 2'

upload-to-test: rm freeze
	$(SOURCE_ENV) 
	python3 setup.py bdist_wheel --universal
	twine upload --repository-url https://test.pypi.org/legacy/ dist/*


upload-to-prod: rm freeze
	python3 setup.py bdist_wheel --universal
	twine upload dist/*


auto_version:
	$(SOURCE_ENV) 
	python3 version.py

venv_rm:
	rm -rdf venv

venv: rm_env
	python3 -m venv --clear venv
	$(SOURCE_ENV)
	pip install -r requirements.txt
		
requirements.txt: 
	$(SOURCE_ENV)
	pip3 freeze > requirements.txt

	

