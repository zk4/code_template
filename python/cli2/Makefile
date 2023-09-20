
# https://cloud.tencent.com/developer/article/2219745?areaSource=106000.3&traceId=tEw9-unty6PU6bYHdCeFC

prepare:
	python3 -m pip install --upgrade build

build:
	python3 -m build

upload:
	twine upload dist/*.whl


run:
	python -m cli2.main

test:
	pytest

test_module_and_function_specified:
	pytest  tests/test_main.py::test_func4

test_function_specified:
	pytest -k test_func4
