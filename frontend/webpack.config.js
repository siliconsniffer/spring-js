
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");

module.exports = {
    module: {
        rules: [
            {
                test: /\.css$/,
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
            filename:'./index.html',
            chunks:["main"]
        }),
        new HtmlWebpackPlugin({
            template: './src/test.html',
            filename:'./test.html',
            chunks:["test"]
        }),
        new CopyPlugin({
            patterns: [
                { from: "assets", to: "assets" }
            ]}),
    ]
};