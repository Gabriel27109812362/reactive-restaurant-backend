const webpack = require('webpack');
const path = require('path');
const nodeExternals = require('webpack-node-externals');

module.exports = {
   entry: './src/index.js',
   mode: 'production',
   target: 'node',
   externals: [
      nodeExternals({
         whitelist: ['express', 'dotenv', 'body-parser'],
      })],
   output: {
      path: path.resolve(__dirname, 'build'),
      filename: 'index.js',
   },
   resolve: {
      modules: ['src', 'node_modules'],
      alias: {
         controllers: path.resolve(__dirname, 'src/controllers'),
         services: path.resolve(__dirname, 'src/services'),
      },
      extensions: ['.js'],

   },
   plugins: [
      new webpack.DefinePlugin({
         'process.env': {
            'APP_PORT': JSON.stringify('4000'),
            'API_KEY': JSON.stringify(process.env.API_KEY),
            'AUTH_DOMAIN': JSON.stringify(process.env.AUTH_DOMAIN),
            'DB_URL': JSON.stringify(process.env.DB_URL),
            'PROJECT_ID': JSON.stringify('rr-be-microservice'),
            'STORE_BUCKET': JSON.stringify(process.env.STORE_BUCKET),
            'MESS_SEND_ID': JSON.stringify(process.env.MESS_SEND_ID),
            'APP_ID': JSON.stringify(process.env.APP_ID),
            'MEASURMENT_ID': JSON.stringify(process.env.MEASURMENT_ID),
         },
      }),
   ],
};


