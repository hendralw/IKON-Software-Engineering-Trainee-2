#addcomment
echo "input your name.."
read dir
echo "input your facebook.."
read fb
echo "input your linkedin.."
read linkedin

mkdir -v $dir
cd $dir
mkdir -v -p "about_me"/{personal,professional}
mkdir -v "my_friends"
mkdir -v "my_system_info"

cd
cd $dir/about_me/personal
touch "facebook.txt" 
echo 'https://www.facebook.com/'$fb >> "facebook.txt"

cd
cd $dir/"about_me"/professional
touch "linkedin.txt"
echo 'https://www.linkedin.com/in/'$linkedin >> "linkedin.txt"

cd
cd $dir/my_friends
touch "list_of_my_friends.txt"
curl -i -X GET \
"https://graph.facebook.com/v15.0/me/friends?access_token=EAAWiuP3y76cBAHrLuEnuAZBW84pFR30UbkZAgcwDbTDNBjOxyU4rTmnHwwpzyMpC7HtotBngu7cZBvWZCdNv508XHff2Adx6kN0M05O7ncA76M8tg7JfWhmzZCna7ORdZAqEtdZBtsrPxqg2lt54CysbRzHaBSGL1Ara4WWTvWasyQliwnDLFbO6F0IldxseG3dC1ADvkpPZA1Q9mZAThMP8VV1h2NszHfrZAR7GcuZCtocqqzJ1svKwlS0" >> "list_of_my_friends.txt"

cd
cd $dir/my_system_info 
uname -a >> "about_this_laptop.txt"

cd
cd $dir/my_system_info
ping forcesafesearch.google.com >> "internet_connection.txt"