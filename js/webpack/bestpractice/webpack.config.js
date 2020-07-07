// 用于引用webpack内置插件
const webpack = require("webpack");
// 外部插件
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
	entry: {
		main: "./src/index.js",
	},
	output: {
		// [name] will follow the dir name
		filename: "[name].js",
		path: __dirname + "/dist",
	},
	module: {
		rules: [
			{
				test: /\.js$/,
				exclude: /node_module/,
				use: "babel-loader",
			},
			{
				test: /\.css$/,
				use: ["style-loader", "css-loader"], // 注意排列顺序，执行顺序与排列顺序相反
			},
		],
	},
	plugins: [
		new webpack.HotModuleReplacementPlugin(),
		new HtmlWebpackPlugin({ template: "./src/index.html" }),
	],
};
