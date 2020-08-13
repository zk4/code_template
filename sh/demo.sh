#!/bin/bash

# if error  then exit script
# when set -e enableed, use this trick to pass through
# lp || true 
# or use set +e to set back in the script 
set -e


# show executeion step with +  
# or use `sh -x test.sh `  in the command line`
# -------------------DEMO-------------
# if [ $# -lt 1 ]
# then
#    echo  "no para"
# else
#    echo "para 1 $1"
# fi
set -x

# if some varialbe undefined, exit
# -------------------DEMO-------------
# if [ "$var" = "abc" ]
# then
#    echo  " not abc"
# else
#    echo " abc "
# fi
set -u

# if cmd in pipeline  failed, do not execute following cmd in pipeline
# -------------------DEMO-------------
# cat test.sh |grep if | cut -d ';' -f 2
set -o pipefail



# set readonly variable like const, overwrite it will get error
# -------------------DEMO-------------
# readonly MY_PATH=/usr/bin
# MY_PATH=/usr/local/bin


# set default vaule for variable
# -------------------DEMO-------------
# name=${1:-shouwang}
