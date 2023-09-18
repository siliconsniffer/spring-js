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
  entry: {
    index: './src/index/index.js',
    login: './src/login/login.js',
    register: './src/register/register.js'
  },
  plugins: [
  new HtmlWebpackPlugin({
    template: './src/index/index.html',
    filename:'index.html',
    inject:true,
    chunks:['index']
  }),
  new HtmlWebpackPlugin({
    template: './src/login/login.html',
    filename:'login.html',
    inject:true,
    chunks:['login']
  }),
  new HtmlWebpackPlugin({
    template: './src/register/register.html',
    filename:'register.html',
    inject:true,
    chunks:['register']
  }),
  new CopyPlugin({
    patterns: [
      { from: "assets", to: "assets" }
    ]}),
]
};

//https://stackoverflow.com/questions/60021318/what-is-the-right-way-to-configure-multiple-pages-in-webpack




