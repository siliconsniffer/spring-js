const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");

module.exports = {
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: [
                    { loader: "style-loader", options: { injectType: "styleTag" } },
                    "css-loader",
                ],
            },

        ],
    },

    mode: 'development',
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html',
            filename:'./index.html'
        }),
        new CopyPlugin({
            patterns: [
                { from: "assets", to: "assets" }
            ]}),
    ]
};