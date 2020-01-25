#coding: utf-8
import os
import yaml
import logging.config
import logging

def setup_logging(default_path='logging.yaml', default_level=logging.DEBUG, env_key='LOG_CFG'):
    mydir = os.path.dirname(os.path.abspath(__file__))
    path = default_path
    path = os.path.join(mydir,path)
    value = os.getenv(env_key, None)
    if value:
        path = value
    if os.path.exists(path):
        with open(path, 'rt') as f:
            try:
                config = yaml.safe_load(f.read())
                logging.config.dictConfig(config)
            except Exception as e:
                print(e)
                print('Error in Logging Configuration. Using default configs')
    else:
        logging.basicConfig(level=default_level)
        print('Failed to load configuration file. Using default configs')

    W  = '\033[0m'  # white (normal)
    R  = '\033[31m' # red
    G  = '\033[32m' # green
    O  = '\033[33m' # orange
    B  = '\033[34m' # blue
    P  = '\033[35m' # purple
    C  = '\033[36m' # cyan
    GR = '\033[37m' # gray

    logging.addLevelName( logging.INFO, G+"%s\033[1;0m" % logging.getLevelName(logging.INFO))
    logging.addLevelName( logging.DEBUG, O+"%s\033[1;0m" % logging.getLevelName(logging.DEBUG))
    logging.addLevelName( logging.WARNING, "\033[1;31m%s\033[1;0m" % logging.getLevelName(logging.WARNING))
    logging.addLevelName( logging.ERROR, "\033[1;41m%s\033[1;0m" % logging.getLevelName(logging.ERROR))
    logging.addLevelName( logging.CRITICAL, "\033[1;41m%s\033[1;0m" % logging.getLevelName(logging.CRITICAL))
