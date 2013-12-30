//
//  main.cpp
//  Zipfsong
//
//  Created by Ben Eisner on 12/29/13.
//  Copyright (c) 2013 Ben Eisner. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Song
{
public:
    long zi;
    string title;
    
    Song(int position, long plays, string title)
    {
        this->title = title;
        this->zi = plays*position;
    }
    
    bool operator<(Song otherSong) const
    {
        return zi > otherSong.zi;
    }

    
};

class SongList
{
private:
    vector<Song> songVector;
    long dispNum;
    
public:
    SongList(long dispNum) {
        this->dispNum = dispNum;
    }
    
    void addSong(Song song) {
        songVector.push_back(song);
        stable_sort(songVector.begin(), songVector.end());
        
        if(songVector.size() > dispNum)
            songVector.pop_back();
        
    }
    
    void displaySongs() {
        for(int i = 0; i < dispNum; i++) {
            cout << songVector[i].title << endl;
        }
    }
};

int main(int argc, const char * argv[])
{
    long tracks;
    long displayNum;
    
    cin >> tracks;
    cin >> displayNum;
    
    SongList songList(displayNum);

    
    for(int i = 1; i <= tracks; i++) {
        long plays;
        string title;
        
        cin >> plays;
        cin >> title;
        
        
        Song song(i, plays, title);
        songList.addSong(song);
    }
    
    songList.displaySongs();
    
    
}

