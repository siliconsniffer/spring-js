
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
  devServer: {
    port: 9000,
    watchFiles: {
      paths: ['src/**'],
      options: {
        usePolling: false,
      },

    },
    proxy: [{
      context: ['/api/**'],
      target: "http://localhost:8080/",
      changeOrigin: true,
    }]
  },
  mode: 'development',
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html',
      filename:'./index.html',
      chunks:["main"]
    }),
    new HtmlWebpackPlugin({
      template: './src/login.html',
      filename:'./login.html',
      chunks:["login"]
    }),
    new CopyPlugin({
      patterns: [
        { from: "assets", to: "assets" }
      ]}),
  ]
};