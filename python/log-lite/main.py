#coding: utf-8
import logx
import logging
logger = logging.getLogger(__name__)

if __name__ == "__main__":
    logger = logger or logging.getLogger(__name__)

    logger.info("hello cinfo")
    logger.error('我们')
    logger.warning('warning')
    logger.error('error')
    logger.critical('critical')

