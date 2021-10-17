common_ignore=[".DS_Store",'.pyc',".o",".obj",".class"]
for filename in [".pyc"]:
    for ci in common_ignore:
        if filename.endswith(ci):
            print("break")
            break
    else:
        print("else")
        continue
