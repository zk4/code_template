import pytest

def add(a, b):
    return a + b

@pytest.mark.parametrize("a, b, expected", [
    (1, 2, 3),
    (0, 0, 0),
])
@pytest.mark.parametrize("description", [
    "positive numbers",
    "zeroes",
])
def test_addition(a, b, expected, description):
    result = add(a, b)
    assert result == expected, description
