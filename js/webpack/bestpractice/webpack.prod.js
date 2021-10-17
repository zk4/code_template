const merge = require('webpack-merge');
const common =require('./webpack.config.js')
module.exports =merge(common, {
	// production  development none
	mode:"production",
	// debug in production with source map
	devtool: 'source-map'
})
